package chapter4.item20;

import java.applet.AudioClip;

public interface Singer {
    AudioClip sing(Song s);
}

public interface SongWriter{
    Song compose(int chartPosition);
}

public interface SingerSongwriter extends Singer, SongWriter{

    AudioClip strum();

    void actSensitive();
}