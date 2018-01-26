(ns demo.routes
  (:import goog.History)
  (:require [secretary.core :as secretary :refer-macros [defroute]]
            [goog.events :as gevents]
            [goog.history.EventType :as EventType]
            [accountant.core :as accountant]))

(def ^:dynamic *dispatch*
  (fn [event] (prn :dispatch event)))

(defroute home "/"  [query-params]
  (*dispatch* [:routes/home query-params]))

(defroute about "/about" []
  (*dispatch* [:routes/about]))

(defn app-routes [dispatch]
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (binding [*dispatch* dispatch]
        (secretary/dispatch! path)))
    :path-exists?
    (fn [path]
      (secretary/locate-route path))})

  (accountant/dispatch-current!))

(defn navigate! [path]
  (accountant/navigate! path))
