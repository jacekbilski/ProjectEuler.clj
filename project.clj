(defproject project-euler.clj "0.1.0-SNAPSHOT"
  :description "Learning Clojure by solving Project Euler problems"
  :url "https://github.com/iassan/ProjectEuler.clj"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot org.bnb.jb.euler.clj
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
