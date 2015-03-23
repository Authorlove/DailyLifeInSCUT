import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class DataInfo {

	public static String[] buildingName = { "C1", "C2", "C3", "C4", "C5", "C6",
			"C7", "C8", "C9", "C10", "C11", "C12", "C13", "C14", "C15", "C16",
			"C17", "A1", "A2", "A3", "A4", "A5", "Canteen1", "Canteen2",
			"Library", "Gym", "Pool", "Tennis", "Basketball", "Basketball",
			"Football Court" };

	// public Rectangle array dorm_C used for constructing the dormitory C1-C17
	// e.g. dorm_C[0] for C1
	public static Rectangle[] dorm_C = { new Rectangle(238, 468, 39, 22),
			new Rectangle(166, 436, 20, 48), new Rectangle(227, 420, 44, 28),
			new Rectangle(92, 385, 73, 29), new Rectangle(188, 379, 58, 30),
			new Rectangle(189, 316, 58, 39), new Rectangle(66, 318, 89, 40),
			new Rectangle(96, 279, 150, 18), new Rectangle(107, 233, 152, 23),
			new Rectangle(200, 170, 59, 44), new Rectangle(105, 171, 60, 43),
			new Rectangle(72, 108, 50, 46), new Rectangle(139, 83, 63, 21),
			new Rectangle(223, 55, 70, 24), new Rectangle(314, 25, 67, 28),
			new Rectangle(305, 81, 61, 29), new Rectangle(210, 132, 104, 25)

	};

	// public Rectangle array dorm_C used for constructing the teachingBuilding
	// A1-A5
	// e.g. teachingBuilding_A[0] for A1
	public static Rectangle[] teachingBuilding_A = {
			new Rectangle(567, 401, 66, 47), new Rectangle(569, 346, 64, 38),
			new Rectangle(564, 288, 69, 40), new Rectangle(614, 231, 61, 34),
			new Rectangle(681, 220, 34, 36) };

	// public Rectangle variable representing the two canteen
	public static Rectangle canteen2 = new Rectangle(382, 98, 42, 66);
	public static Rectangle canteen1 = new Rectangle(296, 282, 110, 110);

	public static Rectangle library = new Rectangle(546, 465, 75, 74);

	public static Rectangle gym = new Rectangle(436, 336, 72, 63);

	public static Rectangle swimmingPool = new Rectangle(453, 275, 65, 41);

	public static Rectangle tennisCourt = new Rectangle(454, 216, 86, 50);

	public static Rectangle[] basketballCourt = {
			new Rectangle(323, 186, 75, 30), new Rectangle(389, 458, 70, 67) };

	public static Rectangle footballCourt = new Rectangle(293, 225, 72, 81);
	

	public static Point libraryEntrance = new Point(library.x, library.y);

	public static Point gymEntry = new Point(gym.x + gym.width, gym.y
			+ gym.height / 2);

	public static Point swimmingPoolEntry = new Point(swimmingPool.x
			+ swimmingPool.width, swimmingPool.y + swimmingPool.height / 2);

	public static Point tennisCourtEntry = new Point(tennisCourt.x+tennisCourt.width,
			tennisCourt.y + tennisCourt.height);

	public static Point[] basketballCourtEntry = {
			new Point(basketballCourt[0].x + basketballCourt[0].width / 2,
					basketballCourt[0].y),
			new Point(basketballCourt[1].x + basketballCourt[1].width,
					basketballCourt[1].y) };

	public static Point footballCourtEntry = new Point(footballCourt.x,
			footballCourt.y + footballCourt.height);
	// public Point array used for recording the entrance of each dormitory
	// e.g entry[0] for the entrance of C1
	public static Point[] entry = {
			new Point(dorm_C[0].x,
					(dorm_C[0].y + dorm_C[0].y + dorm_C[0].height) / 2),
			new Point(dorm_C[1].x + dorm_C[1].width, dorm_C[1].y),
			new Point(dorm_C[2].x,
					(dorm_C[2].y + dorm_C[2].y + dorm_C[2].height) / 2),
			new Point(dorm_C[3].x + dorm_C[3].width,
					(dorm_C[3].y * 2 + dorm_C[3].height) / 2),
			new Point(dorm_C[4].x,
					(dorm_C[4].y + dorm_C[4].y + dorm_C[4].height) / 2),
			new Point(dorm_C[5].x, (dorm_C[5].y * 2 + dorm_C[5].height) / 2),
			new Point(dorm_C[6].x + dorm_C[6].width,
					(dorm_C[6].y * 2 + dorm_C[6].height) / 2),
			new Point((dorm_C[7].x + dorm_C[7].width / 4), dorm_C[7].y
					+ dorm_C[7].height),
			new Point(dorm_C[8].x + dorm_C[8].width / 4, dorm_C[8].y),
			new Point(dorm_C[9].x, dorm_C[9].y + dorm_C[9].height / 2),
			new Point(dorm_C[10].x + dorm_C[10].width, dorm_C[10].y
					+ dorm_C[10].height / 2),
			new Point(dorm_C[11].x + dorm_C[11].width, dorm_C[11].y
					+ dorm_C[11].height / 2),
			new Point(dorm_C[12].x + dorm_C[12].width / 2, dorm_C[12].y
					+ dorm_C[12].height),
			new Point(dorm_C[13].x + dorm_C[13].width / 2, dorm_C[13].y
					+ dorm_C[13].height),
			new Point(dorm_C[14].x + dorm_C[14].width / 2, dorm_C[14].y
					+ dorm_C[14].height),
			new Point(dorm_C[15].x, dorm_C[15].y + dorm_C[15].height / 2),
			new Point(dorm_C[16].x + dorm_C[16].width / 2, dorm_C[16].y) };

	// public Point array used for recording the entrance of each canteen
	// e.g canteenEntrance[0] for the entrance of canteen1
	public static Point[] canteenEntrance = {
			new Point(
					(int) (canteen1.x + canteen1.width / 2 - 55 * Math.sqrt(2) / 2),
					(int) (canteen1.y + canteen1.height / 2 + 55 * Math.sqrt(2) / 2)),
			new Point(canteen2.x, canteen2.y + canteen2.height / 2) };

	// public Point array used for recording the entrance of each
	// teachingBuliding
	// e.g entry_A[0] for the entrance in A1-A5
	public static Point[] entry_A = {
			new Point(teachingBuilding_A[0].x, teachingBuilding_A[0].y
					+ teachingBuilding_A[0].height / 2),
			new Point(teachingBuilding_A[1].x, teachingBuilding_A[1].y
					+ teachingBuilding_A[1].height / 2),
			new Point(teachingBuilding_A[2].x, teachingBuilding_A[2].y
					+ teachingBuilding_A[2].height / 2),
			new Point(
					teachingBuilding_A[3].x + teachingBuilding_A[3].width / 2,
					teachingBuilding_A[3].y + teachingBuilding_A[3].height) };

	public static int name_x[] = { dorm_C[0].x + 40, dorm_C[1].x - 20,
			dorm_C[2].x + 43, dorm_C[3].x, dorm_C[4].x + 57, dorm_C[5].x + 60,
			dorm_C[6].x, dorm_C[7].x, dorm_C[8].x, dorm_C[9].x + 60,
			dorm_C[10].x, dorm_C[11].x, dorm_C[12].x, dorm_C[13].x,
			dorm_C[14].x + 70, dorm_C[15].x + 50, dorm_C[16].x + 105,
			teachingBuilding_A[0].x, teachingBuilding_A[1].x,
			teachingBuilding_A[2].x, teachingBuilding_A[3].x,
			teachingBuilding_A[4].x, canteen1.x + 60, canteen2.x + 45,
			library.x + 80, gym.x + 20, swimmingPool.x - 28,
			tennisCourt.x - 38, basketballCourt[0].x + 75,
			basketballCourt[1].x, footballCourt.x };
	public static int name_y[] = { dorm_C[0].y + 16, dorm_C[1].y + 20,
			dorm_C[2].y + 20, dorm_C[3].y, dorm_C[4].y + 24, dorm_C[5].y + 30,
			dorm_C[6].y, dorm_C[7].y, dorm_C[8].y, dorm_C[9].y + 30,
			dorm_C[10].y, dorm_C[11].y, dorm_C[12].y, dorm_C[13].y,
			dorm_C[14].y + 20, dorm_C[15].y, dorm_C[16].y + 14,
			teachingBuilding_A[0].y, teachingBuilding_A[1].y,
			teachingBuilding_A[2].y, teachingBuilding_A[3].y,
			teachingBuilding_A[4].y, canteen1.y + 80, canteen2.y + 30,
			library.y + 40, gym.y + 75, swimmingPool.y + 15,
			tennisCourt.y + 25, basketballCourt[0].y + 25,
			basketballCourt[1].y + 77, footballCourt.y + 97 };

	// public Point array used for recording nodes
	public static Point[] node = {
		new Point(222,463), //0
		new Point(207,439),  //1
		new Point(185,421),
		new Point(176,397),
		new Point(172,370),
		new Point(171,339),
		new Point(173,310),
		new Point(179,269),
		new Point(183,220),
		new Point(183,193),
		new Point(178,162), //10
		new Point(162,137),
		new Point(186,115),
		new Point(198,125),
		new Point(290,88),
		new Point(198,164),
		new Point(349,61),
		new Point(294,101),
		new Point(257,122),
		new Point(296,121),
		new Point(392,63),//20
		new Point(363,125),
		new Point(338,158),
		new Point(280,226),
		new Point(267,271),
		new Point(268,307),//25 the entrance of football court
		new Point(293,369),
		new Point(252,371),
		new Point(272,409),
		new Point(299,446),
		new Point(331,406),//30
		new Point(442,437),//31
		new Point(481,435),
		new Point(550,431),
		new Point(527,369),//34 the entrance of gym
		new Point(552,367),
		new Point(550,295),//36 swimmingPool
		new Point(550,264),//37 tennis court
		new Point(646,281),
		new Point(591,264),
		new Point(561,218),//40
		new Point(416,182),
		new Point(448,194),
		new Point(466,200),
		new Point(544,456),//44
		new Point(461,451),//45 the entrance of basket2
		new Point(487,539),//46
		new Point(377,167),//47 the entrance of basket1
		new Point(523,412)//48
	};

	// public variables used for recording the the paths between
	// each dormitory entrance and the nodes
	// e.g pathE0_N0 connect the entry of C1 to node0
	public static Paths pathE0_N0 = new Paths(entry[0], node[0], 12);
	public static Paths pathE1_N1 = new Paths(entry[1], node[1], 10);
	public static Paths pathE2_N1 = new Paths(entry[2], node[1], 10);
	public static Paths pathE3_N3 = new Paths(entry[3], node[3], 10);
	public static Paths pathE4_N3 = new Paths(entry[4], node[3], 10);
	public static Paths pathE5_N5 = new Paths(entry[5], node[5], 10);
	public static Paths pathE6_N5 = new Paths(entry[6], node[5], 10);
	public static Paths pathE7_N6 = new Paths(entry[7], node[6], 10);
	public static Paths pathE8_N8 = new Paths(entry[8], node[8], 10);
	public static Paths pathE9_N9 = new Paths(entry[9], node[9], 10);
	public static Paths pathE10_N9 = new Paths(entry[10], node[9], 10);
	public static Paths pathE11_N11 = new Paths(entry[11], node[11], 12);
	public static Paths pathE11_N12 = new Paths(entry[11], node[12], 10);
	public static Paths pathE12_N12 = new Paths(entry[12], node[12], 10);
	public static Paths pathE13_N14 = new Paths(entry[13], node[14], 10);
	public static Paths pathE14_N16 = new Paths(entry[14], node[16], 10);
	public static Paths pathE15_N17 = new Paths(entry[15], node[17], 10);
	public static Paths pathE16_N18 = new Paths(entry[16], node[18], 10);

	// public variable used for recording the paths between
	// each canteen entrance and the nodes
	// e.g pathCE1_N21 connect the entrance of canteen2 to node21
	public static Paths pathCE1_N21 = new Paths(canteenEntrance[1], node[21],
			10);
	public static Paths pathCE0_N26 = new Paths(canteenEntrance[0], node[26],
			10);

	// public variable used for recording the paths between
	// each teachingBuilding entrance and the nodes
	// e.g pathEA0_N33 connect the entrance of A1 to node33
	public static Paths pathEA0_N33 = new Paths(entry_A[0], node[33], 10);
	public static Paths pathEA1_N35 = new Paths(entry_A[1], node[35], 10);
	public static Paths pathEA2_N36 = new Paths(entry_A[2], node[36], 10);
	public static Paths pathEA3_N38 = new Paths(entry_A[3], node[38], 14);

	// public variable used for recording the paths between
	// library entrance and the node
	// pathEL0_N44 connect the entrance of library to node44
	public static Paths pathEL0_N44 = new Paths(libraryEntrance, node[44], 8);

	// gym
	public static Paths pathEG_N34 = new Paths(gymEntry, node[34], 10);

	// football
	public static Paths pathEF_N25 = new Paths(footballCourtEntry, node[25], 12);

	// SWIMMING POOL
	public static Paths pathES_N36 = new Paths(swimmingPoolEntry, node[36], 10);

	// basketball courts
	public static Paths pathEB1_N47 = new Paths(basketballCourtEntry[0],
			node[47], 6);
	public static Paths pathEB2_N45 = new Paths(basketballCourtEntry[1],
			node[45], 6);

	// public variable used for recording the paths between the nodes
	// e.g pathN0_N1 connect the entrance of node0 to node1
	public static Paths pathN0_N1 = new Paths(node[0], node[1], 12);
	public static Paths pathN1_N2 = new Paths(node[1], node[2], 12);
	public static Paths pathN2_N3 = new Paths(node[2], node[3], 12);
	public static Paths pathN3_N4 = new Paths(node[3], node[4], 12);
	public static Paths pathN4_N5 = new Paths(node[4], node[5], 12);
	public static Paths pathN5_N6 = new Paths(node[5], node[6], 12);
	public static Paths pathN6_N7 = new Paths(node[6], node[7], 12);
	public static Paths pathN7_N8 = new Paths(node[7], node[8], 12);
	public static Paths pathN8_N9 = new Paths(node[8], node[9], 12);
	public static Paths pathN9_N10 = new Paths(node[9], node[10], 12);
	public static Paths pathN10_N11 = new Paths(node[10], node[11], 12);
	public static Paths pathN11_N13 = new Paths(node[11], node[13], 8);
	public static Paths pathN12_N13 = new Paths(node[12], node[13], 10);
	public static Paths pathN12_N14 = new Paths(node[12], node[14], 8);
	public static Paths pathN10_N15 = new Paths(node[10], node[15], 10);
	public static Paths pathN13_N15 = new Paths(node[13], node[15], 8);
	public static Paths pathN14_N16 = new Paths(node[14], node[16], 8);
	public static Paths pathN14_N17 = new Paths(node[14], node[17], 8);
	public static Paths pathN13_N18 = new Paths(node[13], node[18], 8);
	public static Paths pathN17_N19 = new Paths(node[17], node[19], 8);
	public static Paths pathN18_N19 = new Paths(node[18], node[19], 8);
	public static Paths pathN16_N20 = new Paths(node[16], node[20], 8);
	public static Paths pathN19_N21 = new Paths(node[19], node[21], 8);
	public static Paths pathN20_N21 = new Paths(node[20], node[21], 12);
	public static Paths pathN15_N22 = new Paths(node[15], node[22], 10);
	public static Paths pathN21_N22 = new Paths(node[21], node[22], 12);
	public static Paths pathN8_N23 = new Paths(node[8], node[23], 8);
	public static Paths pathN22_N23 = new Paths(node[22], node[23], 12);
	public static Paths pathN7_N24 = new Paths(node[7], node[24], 10);
	public static Paths pathN23_N24 = new Paths(node[23], node[24], 12);
	public static Paths pathN6_N25 = new Paths(node[6], node[25], 6);
	public static Paths pathN24_N25 = new Paths(node[24], node[25], 12);
	public static Paths pathN25_N26 = new Paths(node[25], node[26], 12);
	public static Paths pathN4_N27 = new Paths(node[4], node[27], 10);
	public static Paths pathN26_N27 = new Paths(node[26], node[27], 10);
	public static Paths pathN2_N28 = new Paths(node[2], node[28], 6);
	public static Paths pathN27_N28 = new Paths(node[27], node[28], 10);
	public static Paths pathN0_N29 = new Paths(node[0], node[29], 6);
	public static Paths pathN28_N29 = new Paths(node[28], node[29], 10);
	public static Paths pathN26_N30 = new Paths(node[26], node[30], 12);
	public static Paths pathN30_N31 = new Paths(node[30], node[31], 14);
	public static Paths pathN31_N32 = new Paths(node[31], node[32], 10);
	public static Paths pathN32_N33 = new Paths(node[32], node[33], 8);
	public static Paths pathN32_N34 = new Paths(node[32], node[34], 12);
	public static Paths pathN33_N35 = new Paths(node[33], node[35], 12);
	public static Paths pathN34_N35 = new Paths(node[34], node[35], 14);
	public static Paths pathN35_N36 = new Paths(node[35], node[36], 12);
	public static Paths pathN36_N37 = new Paths(node[36], node[37], 12);
	public static Paths pathN37_N38 = new Paths(node[37], node[38], 6);
	public static Paths pathN38_N39 = new Paths(node[38], node[39], 10);
	public static Paths pathN37_N40 = new Paths(node[37], node[40], 12);
	public static Paths pathN39_N40 = new Paths(node[39], node[40], 12);
	public static Paths pathN22_N41 = new Paths(node[22], node[41], 18);
	public static Paths pathN41_N42 = new Paths(node[41], node[42], 14);
	public static Paths pathN42_N43 = new Paths(node[42], node[43], 6);
	public static Paths pathN40_N43 = new Paths(node[40], node[43], 12);
	public static Paths pathN32_N44 = new Paths(node[32], node[44], 10);
	public static Paths pathN31_N45 = new Paths(node[31], node[45], 10);
	public static Paths pathN45_N46 = new Paths(node[45], node[46], 9);
	public static Paths pathN44_N46 = new Paths(node[44], node[46], 6);
	public static Paths pathN41_N47 = new Paths(node[41], node[47], 14);
	public static Paths pathN32_N48 = new Paths(node[32], node[48], 12);
	public static Paths pathN34_N48 = new Paths(node[34], node[48], 14);
	public static Paths pathN44_N45 = new Paths(node[44], node[45], 10);
	public static Paths pathN22_N47 = new Paths(node[22], node[47], 14);
  public static Paths pathTE_N37= new Paths(tennisCourtEntry,node[37],6);
	// public Path object array for storing the paths defined above
	public static Paths[] pathArray = { pathE0_N0, pathE1_N1, pathE2_N1,
			pathE3_N3, pathE4_N3, pathE5_N5, pathE6_N5, pathE7_N6, pathE8_N8,
			pathE9_N9, pathE10_N9, pathE11_N11, pathE11_N12, pathE12_N12,
			pathE13_N14, pathE14_N16, pathE15_N17, pathE16_N18, pathN16_N20,

			pathCE1_N21, pathCE0_N26,

			pathEA0_N33, pathEA1_N35, pathEA2_N36, pathEA3_N38,

			pathEL0_N44,

			pathEG_N34,

			pathEF_N25,

			pathES_N36,

			pathEB1_N47, pathEB2_N45,

			pathN0_N1, pathN1_N2, pathN2_N3, pathN3_N4, pathN4_N5, pathN5_N6,
			pathN6_N7, pathN7_N8, pathN8_N9, pathN9_N10, pathN10_N11,
			pathN11_N13, pathN12_N13, pathN12_N14, pathN10_N15, pathN13_N15,
			pathN14_N16, pathN14_N17, pathN13_N18, pathN17_N19, pathN18_N19,
			pathN19_N21, pathN20_N21, pathN15_N22, pathN21_N22, pathN8_N23,
			pathN22_N23, pathN7_N24, pathN23_N24, pathN6_N25, pathN24_N25,
			pathN25_N26, pathN4_N27, pathN26_N27, pathN2_N28, pathN27_N28,
			pathN0_N29, pathN28_N29, pathN26_N30, pathN30_N31, pathN31_N32,
			pathN32_N33, pathN44_N45, pathN33_N35, pathN34_N35, pathN35_N36,
			pathN36_N37, pathN37_N38, pathN38_N39, pathN37_N40, pathN39_N40,
			pathN22_N47, pathN41_N42, pathN42_N43, pathN40_N43, pathN31_N45,
			pathN45_N46, pathN44_N46, pathN41_N47, pathN32_N48, pathN34_N48,
			pathN32_N44, pathTE_N37 };
	public static Paths[] paths = new Paths[2 * pathArray.length];
	public static ArrayList<Point> vertices = new ArrayList<Point>();
	public static Point[] classroom = new Point[11];
	public static int getPathIndex(Point u, Point v) {
		int i;
		for (i = 0; i < paths.length; i++) {
			if (paths[i].getStartingPoint() == u
					&& paths[i].getEndingPoint() == v)

				break;
		}
		return i;
	}
	

	public static void setVerticesAndPaths() {
		int j=0;
		for (int i = 0; i < entry.length; ++i)
			vertices.add(entry[i]);

		for (int i = 0; i < canteenEntrance.length; ++i)
			vertices.add(canteenEntrance[i]);

		for (int i = 0; i < entry_A.length; ++i){
			vertices.add(entry_A[i]);
			classroom[j++] = entry_A[i];
		}
		
		classroom[j++] = gymEntry;
		classroom[j++] = tennisCourtEntry;
		classroom[j++] = swimmingPoolEntry;
		classroom[j++] = basketballCourtEntry[0];
		classroom[j++] = basketballCourtEntry[1];
		classroom[j++] = footballCourtEntry;
		classroom[j++] = libraryEntrance;
		

		for (int i = 0; i < node.length; ++i)
			vertices.add(node[i]);
		
		vertices.add(footballCourtEntry);
		vertices.add(gymEntry);
		vertices.add(libraryEntrance);
		vertices.add(swimmingPoolEntry);
		vertices.add(tennisCourtEntry);
		for (int i = 0; i < basketballCourtEntry.length; i++)
			vertices.add(basketballCourtEntry[i]);

		for (int i = 0; i < pathArray.length; ++i) {
			paths[i] = pathArray[i];
			paths[pathArray.length + i] = new Paths(
					pathArray[i].getEndingPoint(),
					pathArray[i].getStartingPoint(), pathArray[i].getWidth());
		}

	}

}
