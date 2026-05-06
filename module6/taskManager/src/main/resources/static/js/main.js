document.addEventListener('DOMContentLoaded', () => {
    console.log("JS Loaded and Ready!");

    // ── Theme Toggle ──
    const themeToggle = document.querySelector('#theme-toggle');
    const savedTheme = localStorage.getItem('theme') || 'light';
    document.documentElement.setAttribute('data-theme', savedTheme);

    if (themeToggle) {
        themeToggle.addEventListener('click', () => {
            console.log("Theme toggle clicked");
            const current = document.documentElement.getAttribute('data-theme');
            const next = current === 'dark' ? 'light' : 'dark';
            document.documentElement.setAttribute('data-theme', next);
            localStorage.setItem('theme', next);
        });
    }

    // ── Mark Complete ──
    document.querySelectorAll('.btn-complete').forEach(button => {
        button.addEventListener('click', async () => {
            const taskId = button.getAttribute('data-task-id');
            console.log("Marking task complete: " + taskId);
            const card = button.closest('.task-card');

            try {
                const response = await fetch(`/tasks/${taskId}/complete`, {
                    method: 'PATCH',
                    headers: { 'Content-Type': 'application/json' }
                });

                if (response.ok) {
                    if (card) card.classList.add('done');
                    button.disabled = true;
                    button.textContent = 'Completed';
                }
            } catch (error) {
                console.error('Fetch error:', error);
            }
        });
    });
});