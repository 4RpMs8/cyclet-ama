document.querySelectorAll('.main-image').forEach(box => {
  const img = box.querySelector('.mainProductImage');

  box.addEventListener('mousemove', e => {
    const rect = box.getBoundingClientRect();
    const x = ((e.clientX - rect.left) / rect.width) * 100;
    const y = ((e.clientY - rect.top) / rect.height) * 100;
    img.style.transformOrigin = `${x}% ${y}%`;
  });
  

  box.addEventListener('mouseenter', () => {
    img.style.transform = 'scale(2)';
  });

  box.addEventListener('mouseleave', () => {
    img.style.transform = 'scale(1)';
  });
});