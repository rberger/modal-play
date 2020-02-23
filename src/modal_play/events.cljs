(ns modal-play.events
  (:require
   [re-frame.core :as re-frame]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-db
 :initialize-db
 (fn-traced [__]
            {}))

(re-frame/reg-event-db
 :modal
 (fn-traced [db [_ data]]
            (assoc-in db [:modal] data)))
