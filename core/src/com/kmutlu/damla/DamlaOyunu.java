package com.kmutlu.damla;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class DamlaOyunu implements ApplicationListener{

	private OrthographicCamera kamera;
	private SpriteBatch batch;
	private Texture rsmKova;
	private Rectangle rctKova;

	@Override
	public void create() {

		//kamera
		kamera = new OrthographicCamera();
		kamera.setToOrtho(false, 800, 480);

		//resimler
		rsmKova = new Texture(Gdx.files.internal("kova.png"));

		//SpriteBatch
		batch = new SpriteBatch();

		//dikdörtgenler
		rctKova = new Rectangle();
		rctKova.width = 64;
		rctKova.height = 64;
		rctKova.x = 800 / 2 - rctKova.width / 2;
		rctKova.y = 20;
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

		batch.draw(rsmKova, rctKova.x, rctKova.y);

		batch.end();

		//Kova dokunduğum yere gelecek.
		if (Gdx.input.isTouched()){

			//(x, y, z)üç boyutlu vektör
			Vector3 dokunmaPozisyonu = new Vector3();

			//vektöre dokunulan koordinatları veriyoruz.
			dokunmaPozisyonu.set(Gdx.input.getX(), Gdx.input.getY(), 0);

			//koordinatları oyuna uyarlar.
			kamera.unproject(dokunmaPozisyonu);

			//kovayı taşı
			rctKova.x = dokunmaPozisyonu.x - rctKova.width / 2;

		}
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
