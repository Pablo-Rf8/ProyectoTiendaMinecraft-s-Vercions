document.addEventListener('DOMContentLoaded', () => {

    // 1. SPLASH TEXT
    const frasesMinecraft = [
        "¡Steve está a salvo!",
        "¡100% hecho en Spring Boot!",
        "¡Old School Edition!",
        "¡Vegetta, sube video!",
        "¡No excaves hacia abajo!",
        "¡In5bv en la casa!",
        "¡Texturas translúcidas!",
        "¡Crafteando código!",
        "¡Sumergiéndonos en el CRUD!"
    ];

    const splashElement = document.querySelector('.splash-text');
    if (splashElement) {
        splashElement.textContent = frasesMinecraft[Math.floor(Math.random() * frasesMinecraft.length)];
    }

    // 2. SISTEMA DE PARTÍCULAS
    document.addEventListener('click', (e) => {
        crearParticulas(e.clientX, e.clientY);
    });

    // 3. PROTECCIÓN ANTI-CREEPERS (Eliminar)
    const deleteLinks = document.querySelectorAll('a[href*="eliminar"]');
    deleteLinks.forEach(link => {
        link.addEventListener('click', (event) => {
            event.preventDefault();
            mostrarModalMinecraft("¿ELIMINAR ESTE DATO?", link.getAttribute('href'));
        });
    });

    // 4. PANTALLA DE CARGA DEL LOGIN
    const loginForm = document.querySelector('form[action*="/login"]');
    if (loginForm) {
        loginForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const pantallaCarga = document.getElementById('pantalla-carga');
            const barraProgreso = document.getElementById('barra-progreso');

            if (pantallaCarga && barraProgreso) {
                pantallaCarga.style.display = 'flex';
                let progreso = 0;

                const intervaloCarga = setInterval(() => {
                    progreso += Math.random() * 15 + 5;
                    if (progreso >= 100) {
                        progreso = 100;
                        clearInterval(intervaloCarga);
                        setTimeout(() => { loginForm.submit(); }, 500);
                    }
                    barraProgreso.style.width = progreso + '%';
                }, 200);
            } else {
                loginForm.submit();
            }
        });
    }
});

// FUNCIÓN DE PARTÍCULAS
function crearParticulas(x, y) {
    const colores = ['#555555', '#888888', '#C6C6C6', '#55FF55', '#FFFF55'];
    for (let i = 0; i < 8; i++) {
        const p = document.createElement('div');
        p.style.cssText = `position:fixed; left:${x}px; top:${y}px; width:6px; height:6px; background-color:${colores[Math.floor(Math.random() * colores.length)]}; z-index:9999; pointer-events:none;`;
        document.body.appendChild(p);

        const angle = Math.random() * Math.PI * 2, vel = Math.random() * 6 + 2;
        const vx = Math.cos(angle) * vel; let vy = Math.sin(angle) * vel - 4;
        let life = 1.0;

        const animar = () => {
            vy += 0.4;
            p.style.left = (parseFloat(p.style.left) + vx) + 'px';
            p.style.top = (parseFloat(p.style.top) + vy) + 'px';
            life -= 0.02; p.style.opacity = life;
            if (life > 0) requestAnimationFrame(animar); else p.remove();
        };
        requestAnimationFrame(animar);
    }
}

// FUNCIÓN DEL MODAL
function mostrarModalMinecraft(mensaje, urlAccion) {
    const overlay = document.createElement('div');
    overlay.style.cssText = "position:fixed; top:0; left:0; width:100vw; height:100vh; background:rgba(0,0,0,0.9); display:flex; flex-direction:column; justify-content:center; align-items:center; z-index:10000; font-family:'Press Start 2P', monospace; opacity:0; transition:opacity 0.3s ease;";
    setTimeout(() => overlay.style.opacity = '1', 10);

    const titulo = document.createElement('h2');
    titulo.innerText = mensaje;
    titulo.style.cssText = "color:#FFF; text-shadow:4px 4px 0px #333; margin-bottom:50px; font-size:20px;";

    const btnContainer = document.createElement('div');
    btnContainer.style.cssText = "display:flex; gap:30px;";

    const crearBoton = (texto, colorHover) => {
        const btn = document.createElement('button');
        btn.innerText = texto;
        btn.style.cssText = "padding:18px 35px; cursor:pointer; background:rgba(198,198,198,0.9); border:3px solid #000; box-shadow:inset 3px 3px 0px rgba(255,255,255,0.5), inset -3px -3px 0px rgba(85,85,85,0.5); font-family:'Press Start 2P'; font-size:12px; color:#333; transition:all 0.1s;";
        btn.onmouseover = () => { btn.style.background = colorHover; btn.style.color = '#FFFF55'; btn.style.textShadow = '2px 2px 0px #3F3F15'; };
        btn.onmouseout = () => { btn.style.background = 'rgba(198,198,198,0.9)'; btn.style.color = '#333'; btn.style.textShadow = 'none'; };
        return btn;
    };

    const btnConfirmar = crearBoton('SÍ, PURGAR', 'rgba(255, 85, 85, 0.9)');
    btnConfirmar.onclick = () => window.location.href = urlAccion;
    const btnCancelar = crearBoton('CANCELAR', 'rgba(122, 138, 255, 0.9)');
    btnCancelar.onclick = () => { overlay.style.opacity = '0'; setTimeout(() => overlay.remove(), 300); };

    btnContainer.append(btnConfirmar, btnCancelar);
    overlay.append(titulo, btnContainer);
    document.body.appendChild(overlay);
}