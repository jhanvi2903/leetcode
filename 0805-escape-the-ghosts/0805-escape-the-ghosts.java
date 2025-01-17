class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int targetX = target[0];
        int targetY = target[1];

        int pacToTargetDistance = Math.abs(target[0]) +  Math.abs(target[1]);

        for(int[] ghost : ghosts){
            int ghostX = ghost[0];
            int ghostY = ghost[1];

            int ghostToTargetDistance = Math.abs(targetX - ghostX) + Math.abs(targetY - ghostY);

            if(ghostToTargetDistance <= pacToTargetDistance){
                return false;
            }
        }

        return true;
    }
}