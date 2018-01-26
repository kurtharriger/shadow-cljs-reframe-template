(ns demo.views
  (:require [demo.routes :as routes]
            [demo.subs :as subs]
            [re-frame.core :as re-frame]))

(defn page-view [{:keys [header content]}]
  [:div.page-wrapper
   [:header
    [:a.logo {:href (routes/home)} "Home"]
    [:h1 "Demo"]]
   [:main content]])

(defn about []
  [page-view
    {:content "This is about it."}])

(defn home []
  [page-view
    {:content [:a {:href (routes/about)} "Learn More"]}])

(defn app-view [{:keys [page-id]}]
  (case page-id
    :home
    [home]
    :about
    [about]))

(defn app-root []
  (app-view @(re-frame/subscribe [::subs/app-view])))
