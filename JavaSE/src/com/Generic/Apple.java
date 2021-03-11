package com.Generic;

/**
 * Description
 *
 * @author helaxest
 * @date 2020/10/17  19:55
 * @mail:
 * @since JDK 1.8
 */
public class Apple <T>{

        private T weight;

        public Apple() {
        }

        public Apple(T weight) {
            this.weight = weight;
        }

        public T getWeight() {
            return weight;
        }

        public void setWeight(T weight) {
            this.weight = weight;
        }

}
