(ns modal-play.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [modal-play.events :as events]
   [modal-play.modal :as modal]))

(defn render-view []
  (println "render-view")
  [:div
   [modal/modal]
   [:button {:type "button" :title "Open Modal"
             :class "btn btn-default"
             :on-click #((re-frame/dispatch
                          [:modal {:show? true :child [modal/hello-bootstrap]}
                           ]))}"Open Modal"]])

(defn mount-root []
  (println "mount-root")
  (re-frame/clear-subscription-cache!)
  (reagent/render [render-view]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (println "init")
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
