//package pt.uma.arq.entities.enemies;
//
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.math.Vector2;
//import pt.uma.arq.entities.Ship;
//import pt.uma.arq.entities.enemies.EnemyShip.EnemyShipType;
//
//import java.util.Vector;
//
//public class Fleet {
//    public static final int SHIPS_PER_LINE = 5;
//    public static final int SHIPS_PER_COLUMN = 3;
//    public static final int MARGIN_BETWEEN = 10;
//
//    //public Vector<Vector<EnemyShip>> enemyShips;
//
//    public EnemyShip[][] enemyShips;
//
//    Fleet(Vector2 initialPosition, SpriteBatch batch) {
//        enemyShips = new EnemyShip[SHIPS_PER_LINE][SHIPS_PER_COLUMN];
//
//        for (int i = 0; i < SHIPS_PER_LINE; i++) {
//            for (int j = 0; j < SHIPS_PER_COLUMN; j++) {
//
//                if(i == 0 && j == 0) {
//                    enemyShips[i][j] = EnemyShipFactory.create(EnemyShipType.values()[i], initialPosition, batch);
//                    continue;
//                }
//
//                Ship lastShip = (Ship) enemyShips[i][j - 1];
//
//                initialPosition.x = ((Ship) enemyShips[i - 1][j - 1]).getX() + MARGIN_BETWEEN
//
//                enemyShips[i][j] = EnemyShipFactory.create(EnemyShipType.values()[i], position, batch);
//            }
//        }
//    }
//}
