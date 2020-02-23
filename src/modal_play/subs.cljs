(ns modal-play.subs
  (:require
   [re-frame.core :refer [reg-sub-raw]])
  (:require-macros [reagent.ratom :refer [reaction]]))

(reg-sub-raw
 :modal
 (fn [db _] (println "reg-sub-raw modal") (reaction (:modal @db))))
