package pt.uma.arq.managers;
// Created by 13dev - 01/12/2020

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;


public class AudioManager {

    protected HashMap<String, Sound> sounds;
    protected HashMap<String, Music> songs;
    protected float soundVolume;
    protected float musicVolume;
    protected boolean muted;

    public AudioManager() {
        sounds = new HashMap<>();
        songs = new HashMap<>();
        soundVolume = 1f;
        musicVolume = 1f;
        muted = false;
    }

    public void mute() {
        muted = true;
    }

    public void setSfxVolume(float soundVolume) {
        this.soundVolume = soundVolume;
    }

    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    public void registerSound(String name) {
        sounds.put(
                getNameWithoutPath(name),
                Gdx.audio.newSound(Gdx.files.internal(name))
        );
    }

    public void registerSong(String name) {
        songs.put(
                getNameWithoutPath(name),
                Gdx.audio.newMusic(Gdx.files.internal(name))
        );
    }

    private String getNameWithoutPath(String path) {
        String nameWithoutPath = path.substring(0, path.indexOf("."));
        nameWithoutPath = nameWithoutPath.substring(nameWithoutPath.lastIndexOf("/") + 1);
        return nameWithoutPath;
    }

    public void play(String name) {
        if (!muted) {
            Sound sound = sounds.get(name);
            sound.stop();
            sound.play(soundVolume);
        }
    }

    public void play(String name, float pitch) {
        if (!muted) {
            sounds.get(name)
                    .play(soundVolume, pitch, 0f);
        }
    }

    public void playSong(String name, boolean loop) {
        if (!muted) {
            stopAllSongs();
            songs.get(name).setVolume(musicVolume);
            songs.get(name).setLooping(loop);
            songs.get(name).play();
        }
    }

    public void pauseSong(String name) {
        songs.get(name).pause();
    }

    public void stopSong(String name) {
        songs.get(name).stop();
    }

    public void stopAllSongs() {
        for (Music song : songs.values()) {
            if (song.isPlaying()) {
                song.stop();
            }
        }
    }
}