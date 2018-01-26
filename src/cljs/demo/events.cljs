(ns demo.events
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   {:page :home}))

(re-frame/reg-event-db
 :routes/home
 (fn  [db _]
   (-> db
       (assoc :page :home) )))

(re-frame/reg-event-db
 :routes/about
 (fn  [db _]
   (-> db
       (assoc :page :about))))
