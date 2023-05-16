(ns tech.bilski.euler.clj.numbers)

(def naturals (iterate inc 0))

(defn divisible? [n d] (zero? (mod n d)))

(defn divisible-by-any? [n d1 d2] (or (divisible? n d1) (divisible? n d2)))

(defn fibonacci-fn [a b]
  (cons a (lazy-seq (fibonacci-fn b (+ a b)))))

(def fibonacci (fibonacci-fn 0 1))

(defn primes-fn [s]
  (let [curr (first s)]
    (cons curr (->> (rest s)
                    (filter #(not= 0 (mod % curr)))
                    primes-fn
                    lazy-seq))))

(def primes (primes-fn (drop 2 naturals)))

(defn factorize
  ([x] (factorize x primes {}))
  ([x factors res]
   (if (= x 1)
     res
     (let [curr (first factors)]
       (if (divisible? x curr)
         (recur (/ x curr) factors (assoc res curr (inc (get res curr 0))))
         (recur x (rest factors) res))))))

(defn pow
  ([a b] (pow 1 a b))
  ([acc a b] (if (> b 0)
               (recur (* acc a) a (dec b))
               acc)))

(defn gcd "greatest common divisor" [a b]
  (if (= b 0)
    a
    (if (> a b)
      (recur b (mod a b))
      (recur a (mod b a)))))
