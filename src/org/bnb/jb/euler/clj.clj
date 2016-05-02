(ns org.bnb.jb.euler.clj)

(require 'clojure.set)
(refer 'clojure.set)

(defn multiplesOf
  ([n] (multiplesOf n n))
  ([n curr] (cons curr (lazy-seq (multiplesOf n (+ curr n))))))

(defn solve0001 []
  (apply + (union
             (set (take-while #(< % 1000) (multiplesOf 3)))
             (set (take-while #(< % 1000) (multiplesOf 5))))))

(defn -main [] (print (solve0001)))
