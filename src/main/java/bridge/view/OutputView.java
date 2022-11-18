package bridge.view;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final static String BRIDGE_LENGTH_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private final static String SELECT_TO_MOVE_PLAYER_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printBridgeLengthInputMessage() {
        System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
    }

    public static void printSelectToMovePlayerMessage() {
        System.out.println(SELECT_TO_MOVE_PLAYER_MESSAGE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<Boolean> currentBridge, List<String> bridge) {
        int index = 0;
        StringJoiner topLayer = new StringJoiner(" | ", " [ ", " ] ");
        StringJoiner bottomLayer = new StringJoiner(" | ", " [ ", " ] ");
        for (boolean current : currentBridge) {
            if (current && "U".equals(bridge.get(index))) {
                topLayer.add("O");
                bottomLayer.add(" ");
                continue;
            }
            if (current && "D".equals(bridge.get(index))) {
                topLayer.add(" ");
                bottomLayer.add("O");
                continue;
            }
            if (!current && "D".equals(bridge.get(index))) {
                topLayer.add("X");
                bottomLayer.add(" ");
                continue;
            }
            if (!current && "U".equals(bridge.get(index))) {
                topLayer.add(" ");
                bottomLayer.add("X");
                continue;
            }
            index++;
        }
        System.out.println(topLayer.toString());
        System.out.println(bottomLayer.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
