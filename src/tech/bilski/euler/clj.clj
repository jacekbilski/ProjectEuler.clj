(ns tech.bilski.euler.clj
  (:require [tech.bilski.euler.clj.numbers :refer :all]))

(defn solve0001 []
  (apply + (filter #(divisible-by-any? % 3 5) (take-while #(< % 1000) naturals))))

(defn solve0002 []
  (apply + (filter #(divisible-by-any? % 2) (take-while #(< % 4000000) fibonacci))))

(defn solve0003 []
  (apply max (keys (factorize 600851475143))))

(defn solve0005 []
  (reduce-kv
    #(* %1 (pow %2 %3))
    1
    (reduce
      (partial merge-with max)
      (map factorize (take 20 (rest naturals))))))

(defn solve0006 []
  (-
    (pow (apply + (take 101 naturals)) 2)
    (apply + (map #(pow % 2) (take 101 naturals)))))
