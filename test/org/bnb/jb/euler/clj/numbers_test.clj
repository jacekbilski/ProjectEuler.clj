(ns org.bnb.jb.euler.clj.numbers-test
  (:require [clojure.test :refer :all]
            [org.bnb.jb.euler.clj.numbers :refer :all]))

(deftest factorize-test
  (is (= {2 1} (factorize 2)))
  (is (= {2 2} (factorize 4)))
  (is (= {3 1} (factorize 3)))
  (is (= {2 1 3 1} (factorize 6)))
  (is (= {5 1 7 1 13 1 29 1} (factorize 13195))))
