(ns modal-play.views
  (:require
   [re-frame.core :as re-frame]
   [modal-play.events :as events]
   [modal-play.modal :as modal]))

(defn render-view []
  (println "render-view")
  [:div
   [modal/modal]
   [:header
    [:h1 "Modal Play"]]
   [:main 
    [:p "We got to have something"]
    [:button {:type "button" :title "Open Modal"
              :class "btn btn-primary"
              :on-click #((re-frame/dispatch
                           [:modal {:show? true :child [modal/hello-bootstrap]}
                            ]))}"Open Modal"]]])

