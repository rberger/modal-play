(ns modal-play.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [modal-play.events :as events]
   [modal-play.modal :as modal]
   [modal-play.views :as views]))

(defn mount-root []
  (println "mount-root")
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/render-view]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (println "init")
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))
