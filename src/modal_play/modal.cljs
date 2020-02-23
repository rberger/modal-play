(ns modal-play.modal
  (:require
   [modal-play.subs :as subs]
   [re-frame.core :as re-frame]))

(defn modal-panel
  [{:keys [child size show?]}]
  [:div {:class "modal-wrapper"}
   [:div {:class "modal-backdrop"
          :on-click (fn [event]
                      (do
                        (re-frame/dispatch [:modal {:show? (not show?)
                                                    :child nil
                                                    :size :default}])
                        (.preventDefault event)
                        (.stopPropagation event)))}]
   [:div {:class "modal-child"
          :style {:width (case size
                           :extra-small "15%"
                           :small "30%"
                           :large "70%"
                           :extra-large "85%"
                           "50%")}} child]])

(defn modal []
  (println "modal/modal")
  (let [modal (re-frame/subscribe [:modal])]
    (fn []
      [:div
       (if (:show? @modal)
         [modal-panel @modal])])))


(defn- close-modal []
  (re-frame/dispatch [:modal {:show? false :child nil}]))


(defn hello []
  (println "hello")
  [:div
   {:style {:background-color "white"
            :padding          "16px"
            :border-radius    "6px"
            :text-align "center"}} "Hello modal!"])


(defn hello-bootstrap []
  [:div {:class "modal-dialog"}
   [:div {:class "modal-content"}
    [:div {:class "modal-header bg-warning"}
     [:h4 {:class "modal-title"} "Hello Bootstrap modal!"]
     [:button {:type "button" :title "Cancel"
               :class "close"
               :on-click #(close-modal)} "X"]]
    [:div {:class "modal-body"}
     [:div [:b (str "You can close me by clicking the Ok button"
                    " or by clicking on the X on the upper right"
                    " or by clicking on the backdrop.")]]]
    [:div {:class "modal-footer"}
     [:button {:type "button" :title "Ok"
               :class "btn btn-secondary"
               :on-click #(close-modal)} "Ok"]]]])
