(ns org.bnb.jb.euler.clj.numbers)

(defn naturals
  ([] (naturals 0N))
  ([n] (cons n (lazy-seq (naturals (inc n))))))

(defn divisible-by-any?
  ([n d1] (zero? (mod n d1)))
  ([n d1 d2] (or (zero? (mod n d1)) (zero? (mod n d2)))))

(defn fibonacci
  ([] (fibonacci 0N 1N))
  ([a b] (cons a (lazy-seq (fibonacci b (+ a b))))))

(defn factorize
  ([x] (factorize x (rest (rest (naturals))) {}))
  ([x primes r]
   (if (= x 1N)
     r
     (let [curr (first primes)]
       (if (divisible-by-any? x curr)
         (recur (/ x curr) primes (assoc r curr (+ 1 (get r curr 0))))
         (recur x (rest primes) r))))))
