(ns app.ui.board
  (:require [uix.core :refer [defui $]]))

(defui board []
  ($ :main {:class "min-h-screen p-6"}
     ($ :div {:class "flex gap-4 overflow-x-auto"}
        ($ :section {:class "min-w-72 rounded-lg border border-stone-200 bg-white p-3 shadow-sm"
                     :aria-label "Wishlist column"}
           ($ :header {:class "flex items-center gap-2 pb-2"}
              ($ :span {:class "size-2 rounded-full bg-status-wishlist"
                        :aria-hidden true})
              ($ :h2 {:class "text-sm font-medium text-stone-700"} "Wishlist"))))))
