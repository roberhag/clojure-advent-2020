(ns clojure01.core)
(require '[clojure.string :as s])

(defn readlines
  "Reads each line and returns a seq"
  [fname]
  (s/split-lines (slurp fname)))

;convert each string to int
(def input (map read-string (readlines "resources/input01.txt")))

;Day 1 part 1
(defn mul-if-sum-2020 [& args]
  (if (= 2020 (apply + args))
    (apply * args)
    0))

(defn map2d [f xs ys]
  (map (fn[x] (map (fn[y] (f x y)) xs)) ys))

;Part 2 is just extended to 3d...
(defn map3d [f xs ys zs]
  (map (fn[x] (map (fn[y] (map (fn[z] (f x y z)) xs)) ys)) zs))

(defn first-nonzero [s]
  (first (filter (fn [x] (not (zero? x))) (flatten s))))


(defn -main [& args]
  (println (first-nonzero (map2d mul-if-sum-2020 input input)))
  (println (first-nonzero (map3d mul-if-sum-2020 input input input)))  
)