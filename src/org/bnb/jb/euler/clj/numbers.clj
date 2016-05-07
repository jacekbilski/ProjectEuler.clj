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
