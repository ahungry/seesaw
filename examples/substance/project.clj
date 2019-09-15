(defproject substance "1.0.0-SNAPSHOT"
  :description "Example of using Substance Look and Feel with Seesaw"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [seesaw "1.5.0"]
                 ;; Old and deprecated - only works with java 8
                 ;; [com.github.insubstantial/substance "7.3"]

                 ;; Latest versions, but only work with java 9+
                 ;; [org.pushing-pixels/radiance-substance "2.5.1"]
                 ;; [org.pushing-pixels/radiance-substance "2.0.1"]

                 ;; Seems to work with java 8 and even up to 12
                 [org.pushing-pixels/radiance-substance "1.0.2"]
                 ]
  :main substance.core
  ;; Ensure we target java 8 as much as we can
  :pom-addition [:properties
                 ["maven.compiler.source" "1.8"]
                 ["maven.compiler.target" "1.8"]])
