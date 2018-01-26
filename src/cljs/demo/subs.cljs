(ns demo.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::app-view
 (fn [{:keys [page]}]
   {:page-id page}))
