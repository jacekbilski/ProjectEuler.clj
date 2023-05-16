(ns tech.bilski.euler.clj.numbers-test
  (:require [clojure.test :refer :all]
            [tech.bilski.euler.clj.numbers :refer :all]))

(deftest factorize-test
  (is (= (factorize 2) {2 1}))
  (is (= (factorize 4) {2 2}))
  (is (= (factorize 3) {3 1}))
  (is (= (factorize 6) {2 1, 3 1}))
  (is (= (factorize 13195) {5 1, 7 1, 13 1, 29 1}))
  (is (= (factorize 147875) {5 3, 7 1, 13 2})))

(deftest primes-test
  (is (= (take 10 primes) '(2 3 5 7 11 13 17 19 23 29))))

(deftest pow-test
  (is (= (pow 2 2) 4)))

(deftest gcd-test
  (is (= (gcd 1 1) 1))
  (is (= (gcd 1 2) 1))
  (is (= (gcd 4 2) 2))
  (is (= (gcd 48 18) 6))
  (is (= (gcd 18 48) 6))
  (is (= (gcd 17 5) 1)))
