(ns tech.bilski.euler.clj
  (:require [tech.bilski.euler.clj.numbers :refer :all]))

(defn solve0001 []
  (->> naturals
       (take-while #(< % 1000))
       (filter #(divisible-by-any? % 3 5))
       (apply +)))

(defn solve0002 []
  (->> fibonacci
       (take-while #(< % 4000000))
       (filter #(divisible? % 2))
       (apply +)))

(defn solve0003 []
  (->> (factorize 600851475143)
       keys
       (apply max)))

(defn solve0004 []
  (defn palindrome? [n]
    (let [s (.toString n)] (= s (apply str (reverse s)))))
  (->> (for [a (range 999 99 -1)
            b (range a 99 -1)
            :when (palindrome? (* a b))]
        (* a b))
      (apply max))
  )

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
