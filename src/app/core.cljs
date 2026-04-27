(ns app.core
  (:require [uix.core :refer [defui $]]
            [uix.dom]
            [app.ui.board :as board]))

(defui app []
  ($ board/board))

(defonce root
  (uix.dom/create-root (js/document.getElementById "app")))

(defn ^:export init []
  (uix.dom/render-root ($ app) root))
