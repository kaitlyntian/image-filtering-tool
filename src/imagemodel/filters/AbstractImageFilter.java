package imagemodel.filters;

import imagemodel.model.Image;

import java.util.ArrayList;

/**
 * Filters to process images.
 */
public abstract class AbstractImageFilter implements ImageFilterModel {

  // the kernel of the filter.
  protected ArrayList<ArrayList<Float>> kernel;

  /**
   * constructor for AbstractImageFilter class.
   */
  public AbstractImageFilter() {
    this.kernel = new ArrayList<ArrayList<Float>>();
  }

  /**
   * Get the Kernal from the specific filter model.
   *
   * @return kernal used for the specific model.
   */
  public ArrayList<ArrayList<Float>> getKernel() {
    return this.kernel;
  }

  @Override
  public abstract Image applyTo(Image image);

  @Override
  public void clamp(int[] transformedRGB) {
    for (int u = 0; u < 3; u++) {
      transformedRGB[u] = Math.min(Math.max((transformedRGB[u]), 0), 255);
    }
  }

}
