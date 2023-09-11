import { css } from 'styled-components';

export const sizeStyles = {
	s: css`
		width: 90px;
		height: 40px;
	`,
	m: css`
		width: 150px;
		height: 48px;
	`,
	l: css`
		width: 210px;
		height: 48px;
	`,
	full: css`
		width: 100%;
		height: 100%;
	`,
};

export const colorStyles = {
	Normal: css`
		background-color: var(--gray-100);
		color: var(--gray-500);
	`,
	Primary: css`
		background-color: var(--main-color);
		color: var(--white-color);
	`,
	SubFirst: css`
		background-color: var(--sub-color-1);
		color: var(--white-color);
	`,
	SubSecond: css`
		background-color: var(--sub-color-2);
		color: var(--white-color);
	`,
	Danger: css`
		background-color: var(--danger-color);
		color: var(--white-color);
	`,
	Success: css`
		background-color: var(--success-color);
		color: var(--white-color);
	`,
};

export const radiusStyles = {
	s: css`
		border-radius: var(--radius-s);
	`,
	m: css`
		border-radius: var(--radius-m);
	`,
	l: css`
		border-radius: var(--radius-l);
	`,
};
