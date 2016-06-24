package com.kmutlu.damla;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DamlaOyunu implements ApplicationListener{

	private OrthographicCamera kamera;
	private SpriteBatch batch;
	private Texture rsmKova;

	@Override
	public void create() {

		//kamera
		kamera = new OrthographicCamera();
		kamera.setToOrtho(false, 800, 480);

		//resimler
		rsmKova = new Texture(Gdx.files.internal("kova.png"));

		//SpriteBatch
		batch = new SpriteBatch();
	}

	@Override
	public void render() {
		//Ekranı boyar.
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//kamera güncelle
		kamera.update();

		//sayfa kamera ayar
		batch.setProjectionMatrix(kamera.combined);

		batch.begin();

		batch.draw(rsmKova, 400, 20);

		batch.end();
	}

	@Override
	public void dispose() {

	}
	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}
}
