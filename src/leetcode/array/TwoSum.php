<?php
class Solution {
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    public function Solution1($nums, $target) {
        $map = [];
        $count = count($nums);
        for($i = 0; $i < $count; $i++) {
            $complement = $target-$nums[$i];
            if (array_key_exists($complement, $map)) {
                return [$map[$complement], $i];
            }
            $map[$nums[$i]] = $i;
        }
        return [];
    }

    public function Solution2($nums, $target) {
        $map = array_flip($nums);
        $count = count($nums);
        for($i = 0; $i < $count; $i++) {
            $complement = $target-$nums[$i];
            if (array_key_exists($complement, $map) && $map[$complement] != $i) {
                return [$i, $map[$complement]];
            }
        }
        return [];
    }
}

$test = new Solution();
var_dump($test->Solution1([2,7,11,15], 9));
