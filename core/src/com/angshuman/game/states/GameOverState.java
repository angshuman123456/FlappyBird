package com.angshuman.game.states;

import com.angshuman.game.FlappyBird;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * This will be called when the bird hits the ground or tubes.
 */

public class GameOverState extends State {

    private Texture gameOverImg;
    private Texture background;

    protected GameOverState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, FlappyBird.WIDTH / 2, FlappyBird.HEIGHT / 2);
        gameOverImg = new Texture("gameover.png");
        background = new Texture("bg.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            gsm.set(new MenuState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0);
        sb.draw(gameOverImg, cam.position.x - (gameOverImg.getWidth() / 2), cam.position.y / 2);
        PlayState.scoreFont.draw(sb, PlayState.scoreString, cam.position.x - 15, (cam.position.y * 2) - 4);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        gameOverImg.dispose();
    }
}
