(ns org.bnb.jb.euler.clj.numbers-test
  (:require [clojure.test :refer :all]
            [org.bnb.jb.euler.clj.numbers :refer :all]))

(deftest factorize-test
  (is (= {2N 1} (factorize 2N)))
  (is (= {2N 2} (factorize 4N))))
