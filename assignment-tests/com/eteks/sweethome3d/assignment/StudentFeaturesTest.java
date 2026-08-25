package com.eteks.sweethome3d.assignment;

import com.eteks.sweethome3d.io.DefaultUserPreferences;
import com.eteks.sweethome3d.model.CatalogPieceOfFurniture;
import com.eteks.sweethome3d.model.Home;
import com.eteks.sweethome3d.model.HomePieceOfFurniture;
import com.eteks.sweethome3d.model.Level;
import com.eteks.sweethome3d.model.Wall;
import com.eteks.sweethome3d.swing.FurnitureTable;
import com.eteks.sweethome3d.swing.PlanComponent;
import com.eteks.sweethome3d.viewcontroller.HomeFurnitureController;
import com.eteks.sweethome3d.viewcontroller.HomeView;
import org.junit.jupiter.api.Test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.lang.reflect.Method;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Public acceptance tests for the internship features.
 *
 * Reflection is used for the new volume API so this test class still compiles
 * before students add that API and can report a focused failure message.
 */
class StudentFeaturesTest {
  @Test
  void descriptionIsEditable() {
    HomeFurnitureController controller =
        new HomeFurnitureController(new Home(), null, null, null);

    assertTrue(controller.isPropertyEditable(HomeFurnitureController.Property.DESCRIPTION),
        "Task 2: DESCRIPTION should be editable");
  }

  @Test
  void volumeIsCalculatedAndSortable() throws Exception {
    CatalogPieceOfFurniture catalogPiece = new CatalogPieceOfFurniture(
        "Test piece", null, null, 2f, 3f, 4f, true, false);
    HomePieceOfFurniture smallPiece = new HomePieceOfFurniture(catalogPiece);
    HomePieceOfFurniture largePiece = new HomePieceOfFurniture(
        new CatalogPieceOfFurniture("Large piece", null, null, 3f, 4f, 5f, true, false));

    Method getVolume;
    try {
      getVolume = HomePieceOfFurniture.class.getMethod("getVolume");
    } catch (NoSuchMethodException ex) {
      throw new AssertionError("Task 3: add getVolume() to furniture", ex);
    }
    assertEquals(24f, ((Number)getVolume.invoke(smallPiece)).floatValue(), 0.0001f,
        "Task 3: volume is width x depth x height");

    HomePieceOfFurniture.SortableProperty volume = sortableProperty("VOLUME");
    Comparator<HomePieceOfFurniture> comparator =
        HomePieceOfFurniture.getFurnitureComparator(volume);
    assertNotNull(comparator, "Task 3: VOLUME needs a comparator");
    assertTrue(comparator.compare(smallPiece, largePiece) < 0,
        "Task 3: the VOLUME comparator should order by calculated volume");
  }

  @Test
  void volumeIsVisibleByDefault() {
    HomePieceOfFurniture.SortableProperty volume = sortableProperty("VOLUME");
    Home home = new Home();
    assertTrue(home.getFurnitureVisibleProperties().contains(volume),
        "Task 3: new homes should display the Volume column");

    FurnitureTable table = new FurnitureTable(home, new DefaultUserPreferences());
    boolean volumeHeaderFound = false;
    for (int column = 0; column < table.getColumnModel().getColumnCount(); column++) {
      Object header = table.getColumnModel().getColumn(column).getHeaderValue();
      volumeHeaderFound |= "Volume".equals(header);
    }
    assertTrue(volumeHeaderFound, "Task 3: the furniture table needs a Volume column");
  }

  @Test
  void volumeHasMenuActions() {
    actionType("SORT_HOME_FURNITURE_BY_VOLUME");
    actionType("DISPLAY_HOME_FURNITURE_VOLUME");
  }

  @Test
  void planPrintingIncludesEveryLevelAndRestoresSelection() {
    Home home = homeWithThreeLevels();
    Level originallySelected = home.getLevels().get(2);
    home.setSelectedLevel(originallySelected);
    PlanComponent plan = new PlanComponent(home, new DefaultUserPreferences(), null);
    PageFormat pageFormat = letterPage();
    BufferedImage pageImage = new BufferedImage(800, 1000, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = pageImage.createGraphics();
    try {
      assertEquals(PlanComponent.PAGE_EXISTS, plan.print(graphics, pageFormat, 0));
      assertEquals(PlanComponent.PAGE_EXISTS, plan.print(graphics, pageFormat, 1),
          "Task 4: the second level should have a plan page");
      assertEquals(PlanComponent.PAGE_EXISTS, plan.print(graphics, pageFormat, 2),
          "Task 4: the third level should have a plan page");
      assertEquals(PlanComponent.NO_SUCH_PAGE, plan.print(graphics, pageFormat, 3));
      assertEquals(originallySelected, home.getSelectedLevel(),
          "Task 4: printing must restore the selected level");
    } finally {
      graphics.dispose();
    }
  }

  private static HomePieceOfFurniture.SortableProperty sortableProperty(String name) {
    try {
      return HomePieceOfFurniture.SortableProperty.valueOf(name);
    } catch (IllegalArgumentException ex) {
      throw new AssertionError("Task 3: add VOLUME as a sortable furniture property", ex);
    }
  }

  private static HomeView.ActionType actionType(String name) {
    try {
      return HomeView.ActionType.valueOf(name);
    } catch (IllegalArgumentException ex) {
      throw new AssertionError("Task 3: add the " + name + " menu action", ex);
    }
  }

  private static Home homeWithThreeLevels() {
    Home home = new Home();
    for (int index = 0; index < 3; index++) {
      Level level = new Level("Level " + index, index * 250f, 10f, 240f);
      home.addLevel(level);
      Wall wall = new Wall(0, 0, 200, 0, 10, 240);
      wall.setLevel(level);
      home.addWall(wall);
    }
    return home;
  }

  private static PageFormat letterPage() {
    Paper paper = new Paper();
    paper.setSize(612, 792);
    paper.setImageableArea(36, 36, 540, 720);
    PageFormat pageFormat = new PageFormat();
    pageFormat.setPaper(paper);
    return pageFormat;
  }
}
