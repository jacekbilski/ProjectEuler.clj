(ns tech.bilski.euler.clj.numbers)

(def naturals (iterate inc 0))

(defn divisible-by-any?
  ([n d1] (zero? (mod n d1)))
  ([n d1 d2] (or (zero? (mod n d1)) (zero? (mod n d2)))))

(defn fibonacci-fn [a b]
  (cons a (lazy-seq (fibonacci-fn b (+ a b)))))

(def fibonacci (fibonacci-fn 0 1))

(defn primes-fn [s]
  (let [curr (first s)]
    (cons curr (lazy-seq (primes-fn (filter #(not= 0 (mod % curr)) (rest s)))))))

(def primes (primes-fn (drop 2 naturals)))

(defn factorize
  ([x] (factorize x primes {}))
  ([x factors res]
   (if (= x 1)
     res
     (let [curr (first factors)]
       (if (divisible-by-any? x curr)
         (recur (/ x curr) factors (assoc res curr (+ 1 (get res curr 0))))
         (recur x (rest factors) res))))))

(defn pow
  ([a b] (pow 1 a b))
  ([acc a b] (if (> b 0)
               (recur (* acc a) a (dec b))
               acc)))
