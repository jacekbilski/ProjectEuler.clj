(ns org.bnb.jb.euler.clj
  (:require [org.bnb.jb.euler.clj.numbers :refer :all]))

(defn solve0001 []
  (apply + (filter #(divisible-by-any? % 3 5) (take-while #(< % 1000) naturals))))

(defn solve0002 []
  (apply + (filter #(divisible-by-any? % 2) (take-while #(< % 4000000) fibonacci))))

(defn solve0003 []
  (apply max (keys (factorize 600851475143))))

(defn solve0005old []
  (reduce
    (fn [product factorization]
      (if (empty? factorization)
        product
        (recur (assoc
                 product
                 (key (first factorization))
                 (max
                   (val (first factorization))
                   (get product (key (first factorization)) 0)))
               (rest factorization))))
    (map factorize (take 10 (rest naturals)))))

(defn solve0005 []
  (reduce-kv
    #(* %1 (pow %2 %3))
    1
    (reduce
      (partial merge-with max)
      (map factorize (take 20 (rest naturals))))))
