(ns org.bnb.jb.euler.clj-test
  (:require [clojure.test :refer :all]
            [org.bnb.jb.euler.clj :refer :all]))

(defn solve-problem [problem]
  (problem))

(deftest problem0001
  (is (= 233168M (solve-problem solve0001))))

(deftest problem0002
  (is (= 4613732M (solve-problem solve0002))))

;(deftest problem0003
;  (is (= 6857M (solve-problem solve0003))))
;
;(deftest problem0004
;  (is (= 906609M (solve-problem solve0004))))
;
;(deftest problem0005
;  (is (= 232792560M (solve-problem solve0005))))
;
;(deftest problem0006
;  (is (= 25164150M (solve-problem solve0006))))
;
;(deftest problem0007
;  (is (= 104743M (solve-problem solve0007))))
;
;(deftest problem0008
;  (is (= 40824M (solve-problem solve0008))))
;
;(deftest problem0009
;  (is (= 31875000M (solve-problem solve0009))))
