(ns app.core
  (:require
    [clojure.string :as str]
    [solid.core :as s :refer [$ defui]]))

(defui app []
  ($ :div {:class "text-3xl font-bold underline"}
     "Hello World" ))

(defn render-app []
  (s/render ($ app) (js/document.getElementById "root")))

;; hot-reloading setup
(defonce dispose (atom (render-app)))

(defn ^:dev/after-load reload []
  (@dispose)
  (reset! dispose (render-app)))
