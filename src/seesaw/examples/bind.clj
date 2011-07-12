;  Copyright (c) Dave Ray, 2011. All rights reserved.

;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this 
;   distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns seesaw.examples.bind
  (:use [seesaw core border])
  (:require [seesaw.bind :as b]))

(defn regex-box [& opts]
  (let [t (text :id :search :columns 20 :border [5 (line-border)])
        s (label :text "Ready" :h-text-position :left)]
    (b/bind 
      ; As the text of the textbox changes ...
      t
      ; Convert it to a regex, or nil if it's invalid
      (b/transform #(try (re-pattern %) (catch Exception e nil)))
      ; Now split into two paths ...
      (b/tee
        ; The first path sets the color of the text box depending
        ; on whether the regex was valid
        (b/bind 
          (b/transform #(if % "white" "lightcoral")) 
          (b/property t :background))
        ; The second path sets the text of the status label
        (b/bind 
          (b/transform #(if % "Ready" "Invalid regex")) 
          s)))
    (border-panel 
      :north "Enter a search string:" 
      :center t 
      :south s :vgap 5 :border 5)))

(defn app []
  (let [f (frame 
           :title "Seesaw (bind) example"
           :content (border-panel :north (checkbox :id :enable 
                                                   :text "Enable search"
                                                   :selected? true)
                                  :center (regex-box)))]
    ; Bind the selection of the check box to the enabled state
    ; of the search box
    (b/bind (b/selection (select f [:#enable]))
            (b/property  (select f [:#search]) :enabled?))
    f))

(defn -main [& args]
  (invoke-now
    (->
      (app)
      pack!
      show!)))

;(-main)

