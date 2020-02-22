(ns modal-play.events
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-event-db
 :initialize-db
 {:modal {}})

(re-frame/reg-event-db
:modal
(fn [db [_ data]]
  (assoc-in db [:modal] data)))
