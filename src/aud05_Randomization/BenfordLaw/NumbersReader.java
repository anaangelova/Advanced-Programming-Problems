package aud05_Randomization.BenfordLaw;

import java.io.InputStream;
import java.util.List;

public interface NumbersReader {

    List<Integer> read(InputStream inputStream);
}
