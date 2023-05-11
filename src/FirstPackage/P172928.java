package FirstPackage;

public class P172928 {
    public static int[] solution2(String[] park, String[] routes) {
        int[] answer;
        int x, y;
        x = -1;
        y = -1;
        for (int i=0; i<park.length; i++) {
            for (int j=0; j<park[0].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != -1 && y != -1) break;
        }

        for (int i=0; i<routes.length; i++) {
            String[] command = routes[i].split(" ");
            boolean flag = true;
            int dx, dy, step;
            dx = x;
            dy = y;
            step = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "N":
                    dx -= step;
                    if (dx < 0) {
                        flag = false;
                        break;
                    }
                    if (!flag) break;
                    for (int k=x; k >= dx; k--) {
                        if (park[k].charAt(y) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    break;
                case "S":
                    dx += step;
                    if (dx >= park.length) {
                        flag = false;
                        break;
                    }
                    if (!flag) break;
                    for (int k=x; k <= dx; k++) {
                        if (park[k].charAt(y) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    break;
                case "W":
                    dy -= step;
                    if (dy < 0) {
                        flag = false;
                        break;
                    }
                    if (!flag) break;
                    for (int k=y; k >= dy; k--) {
                        if (park[x].charAt(k) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    break;
                case "E":
                    dy += step;
                    if (dy >= park[0].length()) {
                        flag = false;
                        break;
                    }
                    if (!flag) break;
                    for (int k=y; k <= dy; k++) {
                        if (park[x].charAt(k) == 'X') {
                            flag = false;
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }

            if (flag) {
                x = dx;
                y = dy;
            }
        }
        answer = new int[] {x, y};
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new String[] {"SOO", "OOO", "OOO"}, new String[] {"E 2","S 2","W 1"})); // [2, 1]
        System.out.println(solution2(new String[] {"SOO","OXX","OOO"}, new String[] {"E 2","S 2","W 1"})); // [0, 1]
        System.out.println(solution2(new String[] {"OSO","OOO","OXO","OOO"}, new String[] {"E 2","S 3","W 1"})); // [0, 0]
    }
}
