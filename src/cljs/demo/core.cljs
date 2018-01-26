(ns demo.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [demo.events :as events]
            [demo.subs :as subs]
            [demo.views :as views]
            [demo.routes :as routes]
            [demo.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/app-root]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (dev-setup)
  (re-frame/dispatch-sync [::events/initialize-db])
  (routes/app-routes re-frame/dispatch)
  (mount-root))
