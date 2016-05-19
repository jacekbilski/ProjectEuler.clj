(ns org.bnb.jb.euler.clj.numbers)

(def naturals (iterate inc 2))

(defn divisible-by-any?
  ([n d1] (zero? (mod n d1)))
  ([n d1 d2] (or (zero? (mod n d1)) (zero? (mod n d2)))))

(defn fibonacci-fn
  [a b] (cons a (lazy-seq (fibonacci-fn b (+ a b)))))

(def fibonacci (fibonacci-fn 0 1))

(defn primes-fn [s]
  (let [curr (first s)]
    (cons curr (lazy-seq (primes-fn (filter #(not= 0 (mod % curr)) (rest s)))))))

(def primes (primes-fn naturals))

(defn factorize
  ([x] (factorize x primes {}))
  ([x factors r]
   (if (= x 1)
     r
     (let [curr (first factors)]
       (if (divisible-by-any? x curr)
         (recur (/ x curr) factors (assoc r curr (+ 1 (get r curr 0))))
         (recur x (rest factors) r))))))
