(ns org.bnb.jb.euler.clj.numbers)

(defn naturals
  ([] (naturals 0))
  ([n] (cons n (lazy-seq (naturals (inc n))))))

(defn divisible-by-any?
  ([n d1] (zero? (mod n d1)))
  ([n d1 d2] (or (zero? (mod n d1)) (zero? (mod n d2)))))

(defn fibonacci
  ([] (fibonacci 0 1))
  ([a b] (cons a (lazy-seq (fibonacci b (+ a b))))))

(defn primes
  ([] (primes (rest (rest (naturals)))))
  ([s] (let [curr (first s)]
         (cons curr (lazy-seq (primes (filter #(> (mod % curr) 0) (rest s))))))))

(defn factorize
  ([x] (factorize x (rest (rest (primes))) {}))
  ([x primes r]
   (if (= x 1)
     r
     (let [curr (first primes)]
       (if (divisible-by-any? x curr)
         (recur (/ x curr) primes (assoc r curr (+ 1 (get r curr 0))))
         (recur x (rest primes) r))))))
