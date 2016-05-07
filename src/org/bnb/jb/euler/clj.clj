(ns org.bnb.jb.euler.clj
  (:require [org.bnb.jb.euler.clj.numbers :refer :all]))

(defn multiplesOf
  ([n] (multiplesOf n n))
  ([n curr] (cons curr (lazy-seq (multiplesOf n (+ curr n))))))

(defn solve0001 []
  (apply + (filter #(divisible-by-any? % 3 5) (take-while #(< % 1000) (naturals)))))

(defn -main [] (println (solve0001)))
