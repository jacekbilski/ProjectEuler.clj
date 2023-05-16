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

(defn solve0009 []
  ; this almost exactly implements the algorithm described in https://projecteuler.net/overview=0009
  (let [s 1000
        s2 (/ s 2)
        m-limit (- (Math/ceil (Math/sqrt s2)) 1)]
    (->> (for [m (range 2 m-limit)
               :when (= 0 (mod s2 m))
               :let [sm (/ s2 m)
                     k-start (if (= (mod m 2) 1) (+ m 2) (+ m 1))]
               k (range k-start s 2)
               :while (and (< k (* 2 m)) (<= k sm))
               :when (and (= (mod sm k) 0) (= (gcd k m) 1))
               :let [d (/ s2 (* k m))
                     n (- k m)
                     a (* d (- (pow m 2) (pow n 2)))
                     b (* 2 d m n)
                     c (* d (+ (pow m 2) (pow n 2)))]]
           (* a b c))
         first))
  )
