
const $ = (sel, ctx=document) => ctx.querySelector(sel);
const $$ = (sel, ctx=document) => Array.from(ctx.querySelectorAll(sel));

document.addEventListener('DOMContentLoaded', () => {
  $$('img[data-src]').forEach(img => {
    const obs = new IntersectionObserver(entries => {
      entries.forEach(e => {
        if (e.isIntersecting) {
          img.src = img.dataset.src;
          obs.disconnect();
        }
      });
    });
    obs.observe(img);
  });
});
